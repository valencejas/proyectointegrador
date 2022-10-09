import { HttpEvent, HttpHandler, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { TokenService } from "./token.service";
@Injectable({
    providedIn: 'root'
})
export class InterceptorService {
    constructor(private tokenSrvice: TokenService){}

    intercept(req: HttpRequest<any>, netx: HttpHandler): Observable<HttpEvent<any>>{
        let intReq = req;
        const token = this.tokenSrvice.getToken();
        if(token != null){
            intReq  = req.clone({
                headers: req.headers.set('Authorization', 'Bearer' + token)
            });
        }
        return netx.handle(intReq);
    }
}

export const interceptorProvider = [{
    provide: HTTP_INTERCEPTORS,
    useClass: InterceptorService,
    multi: true,
}];