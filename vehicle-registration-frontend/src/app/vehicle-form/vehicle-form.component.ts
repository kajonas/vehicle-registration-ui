import { Component } from '@angular/core';
import { ReactiveFormsModule, FormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgIf, NgFor } from '@angular/common';
import {HttpClientModule} from '@angular/common/http';

@Component({
  selector: 'app-vehicle-form',          // ✅ This is okay to keep
  standalone: true,                      // ✅ This is essential
  imports: [ReactiveFormsModule, FormsModule, HttpClientModule, NgIf, NgFor],
  templateUrl: './vehicle-form.component.html',
  styleUrls: ['./vehicle-form.component.css']
})
export class VehicleFormComponent {
  form: FormGroup;

  constructor(private fb: FormBuilder) {
    this.form = this.fb.group({
      owner: ['', Validators.required],
      vin: ['', Validators.required],
      year: [null, Validators.required]
    });
  }

  onSubmit(): void {
    alert(JSON.stringify(this.form.value, null, 2));
    this.form.reset();
  }
}
