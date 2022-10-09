import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { LoginUsuario } from 'src/app/model/login-usuario';
import { AuthService } from 'src/app/servicio/auth.service';
import { TokenService } from 'src/app/servicio/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})


export class LoginComponent implements OnInit {
  isLogged = false;
  isLogginFail = false;
  loginUsuario! : LoginUsuario;
  nombreUsuario! :string;
  clave! : string;
  roles: string[] =[];
  errorMjs! : string;
  



  constructor(private tokenService: TokenService, private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    if(this.tokenService.getToken()){
      this.isLogged = true;
      this.isLogginFail = false;
      this.roles = this.tokenService.getAutorities();
    }
  }

  onLogin(): void{
    this.loginUsuario = new LoginUsuario(this.nombreUsuario, this.clave)
      ; this.authService.login(this.loginUsuario).subscribe(data =>{
        this.isLogged = true;
        this.isLogginFail = false;
        this.tokenService.setToken(data.token);
        this.tokenService.setUserName(data.nombreUsuario);
        this.tokenService.setAuthorities(data.authorities);
        this.roles = data.authorities;
        this.router.navigate([""])
      }, err => {
        this.isLogged = false;
        this.isLogginFail = true;
        this.errorMjs = err.error.mensaje;
        console.log(this.errorMjs)
      }
      )
  }

}
