import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration, withEventReplay } from '@angular/platform-browser';
import { provideHttpClient, withInterceptors, withJsonpSupport } from '@angular/common/http';
import { provideStore } from '@ngrx/store';
import { userReducer } from '../store/user/user.reducer';
import { authInterceptor } from './services/interceptor/auth.interceptor';


export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }), 
    provideRouter(routes),
    // provideClientHydration(withEventReplay()),
    provideHttpClient(withJsonpSupport(), withInterceptors([authInterceptor])),
    provideStore({user:userReducer})
  ]
};
