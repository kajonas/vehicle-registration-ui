import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgFor, AsyncPipe } from '@angular/common';

import { VehicleService } from '../../services/vehicle.service';
import { Make } from '../../models/make.model';
import { Model } from '../../models/model.model';

@Component({
  selector: 'app-vehicle-form',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    NgFor
  ],
  templateUrl: './vehicle-form.component.html',
  styleUrls: ['./vehicle-form.component.css']
})
export class VehicleFormComponent implements OnInit {
  form: FormGroup;
  makes: Make[] = [];
  models: Model[] = [];

  constructor(private fb: FormBuilder, private service: VehicleService) {
    this.form = this.fb.group({
      owner: ['', Validators.required],
      vin: ['', Validators.required],
      year: [null, [Validators.required, Validators.min(1900)]],
      make: [null, Validators.required],
      model: [null, Validators.required]
    });
  }

  ngOnInit(): void {
    this.service.getMakes().subscribe(data => this.makes = data);
    this.form.get('make')?.valueChanges.subscribe(make => {
      this.models = [];
      if (make?.id) {
        this.service.getModels(make.id).subscribe(models => this.models = models);
      }
    });
  }

  onSubmit(): void {
    if (this.form.valid) {
      this.service.saveVehicle(this.form.value).subscribe(v => {
        alert(`Vehicle saved with ID ${v.id}`);
        this.form.reset();
      });
    }
  }
}
