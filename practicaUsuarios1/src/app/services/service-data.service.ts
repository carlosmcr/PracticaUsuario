import { Injectable } from '@angular/core';
import { Usuario } from '../model/usuario';
import { HttpClient } from '@angular/common/http';
import { Respuesta } from '../model/respuesta';

@Injectable({
  providedIn: 'root'
})
export class ServiceDataService {

  constructor(public httpClient: HttpClient) { }

  retornarAddUsuario(Usuario){

    return this.httpClient.post<Usuario>('http://192.168.1.49:8088/usuario', Usuario);
  }

  retornarUsuario(user: Usuario){

    return this.httpClient.post<Respuesta>('http://192.168.1.49:8088/usuario/seguridad', user);
  }

  retornarListUsuario(){

    return this.httpClient.get<Array<Usuario>>('http://192.168.1.49:8088/usuario');
  }
}
