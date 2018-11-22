import { Component, OnInit } from '@angular/core';
import { Usuario } from '../model/usuario';
import { NgForm } from '@angular/forms';
import { ServiceDataService } from '../services/service-data.service';

@Component({
  selector: 'app-registro-usuario',
  templateUrl: './registro-usuario.component.html',
  styles: []
})
export class RegistroUsuarioComponent implements OnInit {

  public user: Usuario;

  constructor(public remote: ServiceDataService) {
    this.user = new Usuario();
  }

  ngOnInit() {
  }

  onSubmit(f: NgForm){
    console.log(this.user);

    this.remote.retornarAddUsuario(this.user).subscribe(ok =>{
      console.log(ok);
    });
  }

  limpiar(f: NgForm){
    f.reset();
  }

}
