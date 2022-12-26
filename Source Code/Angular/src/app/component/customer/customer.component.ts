import { CustomerService } from './../../service/customer.service';
import { Component, ElementRef, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customerForm!: FormGroup;
  isProgressing = false;
  isUpdate = false;

  constructor(
    private _formBuilder: FormBuilder,
    private _elementRef: ElementRef,
    private _customerService: CustomerService,
    private _router: Router,
    private _route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.createForm();
    const accNo = this._route.snapshot.paramMap?.get('accNo');
    if (accNo) {
      this.isUpdate = true;
      this.getCustomer(accNo);
    }
  }

  private createForm(): void {
    this.customerForm = this._formBuilder.group({
      accNo: ['', [Validators.required]],
      name: ['', [Validators.required]],
      nic: ['', [Validators.required]],
      contactNo: ['', [Validators.required]],
      address: ['', [Validators.required]]
    });
  }

  private getCustomer(accNo: any) {
    this._customerService.getCustomer(accNo).subscribe(response => {
      this.customerForm.setValue(response);
    },
      error => {
        console.log(error);
      })
  }

  submitForm() {
    this.isProgressing = true;
    if (this.customerForm.valid) {
      if (this.isUpdate) {
        this._customerService.updateCustomer(this.customerForm.value).subscribe(
          response => {
            this._router.navigate(['/customers/view']);
          },
          error => {
            console.log(error);
          }
        ).add(() => this.isProgressing = false);
      } else {
        this._customerService.createCustomer(this.customerForm.value).subscribe(
          response => {
            this._router.navigate(['/customers/view']);
          },
          error => {
            console.log(error);
          }
        ).add(() => this.isProgressing = false);
      }
    } else {
      this.isProgressing = false;
      this.scrollToFirstInvalidControl();
    }
  }

  scrollToFirstInvalidControl(): void {
    const firstInvalidControl: HTMLElement = this._elementRef.nativeElement.querySelector('form .ng-invalid');
    firstInvalidControl.scrollIntoView({ behavior: 'smooth' });
  }

  resetForm(): void {
    this.customerForm.reset();
    this._elementRef.nativeElement.querySelector('#course-name').scrollIntoView();
  }

}
