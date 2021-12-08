import { ServicePourDemoAsyncValidatorService } from './../../services/service-pour-demo-async-validator.service';
import { Observable } from 'rxjs';
import { AbstractControl, AsyncValidatorFn, FormGroup } from '@angular/forms';
import { ValidationErrors } from '@angular/forms';
import { CustomValidator } from './../../validators/custom-validator';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { debounceTime, map } from 'rxjs/operators';

@Component({
  selector: 'app-formulaire-pilote-par-code',
  templateUrl: './formulaire-pilote-par-code.component.html',
  styleUrls: ['./formulaire-pilote-par-code.component.css'],
})
export class FormulairePiloteParCodeComponent implements OnInit {
  monForm: FormGroup;
  prenomControl: FormControl;
  //nomControl: FormControl;
  prenom: string = '';

  constructor(
    private fb: FormBuilder,
    private service: ServicePourDemoAsyncValidatorService
  ) {
    this.prenomControl = this.fb.control('', [
      Validators.required,
      Validators.pattern(/^[a-zA-Z]{1,}((\s|-)[a-zA-Z]{2,})*$/),
      CustomValidator.pasOlivier,
    ]);
    //this.nomControl = this.fb.control('', Validators.required);
    this.monForm = this.fb.group({
      prenomControl: this.prenomControl,
      nomControl: this.fb.control(
        '',
        [Validators.required, CustomValidator.pasTexte('toto')],
        this.checkPasDansList()
      ),
      group1: this.fb.group(
        {
          texte1Control: this.fb.control(''),
          texte2Control: this.fb.control(''),
        },
        { validators: this.checkEquals }
      ),
    });
  }

  checkPasDansList(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.service.checkDataInList(control.value).pipe(
        debounceTime(1000),
        map((res: boolean) => {
          return res ? { checkDataInList: true } : null;
        })
      );
    };
  }

  checkEquals(group: AbstractControl): ValidationErrors | null {
    let formGroup: FormGroup = group as FormGroup;
    return formGroup.controls.texte1Control.value !=
      formGroup.controls['texte2Control'].value
      ? { checkEquals: true }
      : null;
  }

  ngOnInit(): void {}

  submit() {
    console.log(this.monForm.controls.nomControl);
  }
}
