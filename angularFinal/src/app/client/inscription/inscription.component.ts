import { ClientService } from './../../services/client.service';
import { Observable } from 'rxjs';
import {
  AbstractControl,
  ValidationErrors,
  AsyncValidatorFn,
} from '@angular/forms';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Civilite } from './../../model/civilite';
import { Component, OnInit } from '@angular/core';
import { debounceTime, map } from 'rxjs/operators';
import { Client } from 'src/app/model/client';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  civilites = Civilite;
  form: FormGroup;

  constructor(private clientService: ClientService) {
    this.form = new FormGroup({
      prenom: new FormControl('', [
        Validators.required,
        Validators.pattern(/^[a-zA-Z]{1,}((\s|-)[a-zA-Z]{2,})*$/),
        Validators.maxLength(200),
      ]),
      nom: new FormControl('', [
        Validators.required,
        Validators.pattern(/^[a-zA-Z]{1,}((\s|-)[a-zA-Z]{2,})*$/),
        Validators.maxLength(200),
      ]),
      civilite: new FormControl(''),
      login: new FormControl('', Validators.required, this.checkLogin()),
      passwordGroup: new FormGroup(
        {
          password: new FormControl('', [
            Validators.required,
            Validators.pattern(
              /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])([a-zA-Z0-9$@#_-]{5,25})$/
            ),
          ]),
          confirm: new FormControl(''),
        },
        this.checkNotEquals
      ),
    });
  }

  checkLogin(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.clientService.checkLogin(control.value).pipe(
        debounceTime(1000),
        map((res: boolean) => {
          return res ? { loginUsed: true } : null;
        })
      );
    };
  }

  checkNotEquals(group: AbstractControl): ValidationErrors | null {
    let formGroup: FormGroup = group as FormGroup;
    console.log(formGroup);
    if (formGroup.controls.password.errors) {
      return null;
    }
    return formGroup.controls.password.value != formGroup.controls.confirm.value
      ? { checkNotEquals: true }
      : null;
  }

  save() {
    this.clientService
      .insert(
        new Client(
          undefined,
          this.form.controls.prenom.value,
          this.form.controls.nom.value,
          this.form.controls.civilite.value,
          this.form.controls.login.value
        ),
        this.form.get('passwordGroup.password')!.value
      )
      .subscribe((client) => {
        console.log(client);
      });
  }

  ngOnInit(): void {}

  nomErrorMessage() {
    if (this.form.get('nom')!.hasError('required')) {
      return 'nom obligatoire';
    } else if (this.form.get('nom')!.hasError('pattern')) {
      return 'uniquement des lettres avec espace ou -';
    }
    return 'maximum 200 caracteres';
  }
}
