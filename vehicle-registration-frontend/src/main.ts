import { bootstrapApplication } from '@angular/platform-browser';
import { importProvidersFrom } from '@angular/core';
import { VehicleFormComponent } from './app/components/vehicle-form/vehicle-form.component';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

bootstrapApplication(VehicleFormComponent, {
  providers: [
    importProvidersFrom(
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule
    )
  ]
});
