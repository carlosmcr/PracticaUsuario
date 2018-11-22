import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Usuario } from '../model/usuario';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { ServiceDataService } from '../services/service-data.service';
import { Observable } from 'rxjs';
import { Respuesta } from '../model/respuesta';

@Component({
  selector: 'app-inicio-sesion',
  templateUrl: './inicio-sesion.component.html',
  styleUrls: [ 'style.css']
})
export class InicioSesionComponent implements OnInit {

  public dataRespuesta: Observable<Respuesta>;
  public datos: Respuesta;
  public user: Usuario;
  public dataUser: Observable<Array<Usuario>>;
  public listaUser = [];

  constructor(public remote: ServiceDataService) {
    this.user = new Usuario();
  }

  ngOnInit() {
  }

  onSubmit(f: NgForm){
    console.log(this.user);
    this.dataRespuesta = this.remote.retornarUsuario(this.user);

    this.dataRespuesta.subscribe(arrayData =>{
      console.log(arrayData);
      this.datos = arrayData;

      if (this.datos.mensaje === 'Correcto') {
        this.dataUser = this.remote.retornarListUsuario();

        this.dataUser.subscribe( arrayUser => {
          this.listaUser = arrayUser;
        }, error =>{
          console.error("Error en el array de User"+error);
        });
      } else {
        //console.log("Entro en else");
      }
    }, error =>{
      console.error("Error en la llamada"+error);
    });
  }

  limpiar(f: NgForm){
    f.reset();
  }

  getCSSClasses(modo: string) {
    let cssClasses;
    if (modo === 'Correcto') {
      //console.log("Entro en css");
      cssClasses = {
        'oculto': true,
        'visible': false
      }
    } else {
      cssClasses = {
        'oculto': false,
        'visible': true
      }
    }
    return cssClasses;
  }


}
