import { ClientService } from './../../services/client.service';
import { Civilite } from './../../model/civilite';
import { Client } from './../../model/client';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit-client',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.css'],
})
export class EditClientComponent implements OnInit {
  client: Client = new Client();
  password: string = '';
  civilites = Civilite;

  constructor(
    private activatedRoute: ActivatedRoute,
    private clientService: ClientService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (!!params['client']) {
        this.clientService.byId(params['client']).subscribe((client) => {
          this.client = client;
        });
      }
      // console.log(this.client);
      // console.log(params);
      // this.client = new Client(
      //   params._id,
      //   params._prenom,
      //   params._nom,
      //   params._civilite,
      //   !!params._login ? params._log : ''
      // );
      // console.log(this.client);
    });
  }

  save() {
    if (!!this.client.id) {
      this.clientService.update(this.client).subscribe((result) => {
        this.goList();
      });
    } else {
      this.clientService
        .insert(this.client, this.password)
        .subscribe((result) => {
          this.goList();
        });
    }
  }
  goList() {
    this.router.navigate(['/clients']);
  }
}
