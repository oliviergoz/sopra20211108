import { ClientService } from './../../services/client.service';
import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/model/client';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css'],
})
export class ClientComponent implements OnInit {
  clients: Client[] = [];

  constructor(private clientService: ClientService) {}

  ngOnInit(): void {
    this.initClients();
  }

  initClients() {
    this.clientService.allClients().subscribe((result: any[]) => {
      this.clients = [];
      for (let value of result) {
        this.clients.push(
          new Client(
            value['id'],
            value['prenom'],
            value['nom'],
            value['civilite'],
            !!value.user ? value.user.login : undefined
          )
        );
      }
    });
  }

  delete(id: number | undefined) {
    if (!!id) {
      this.clientService.delete(id).subscribe((result) => {
        this.initClients();
      });
    }
  }
}
