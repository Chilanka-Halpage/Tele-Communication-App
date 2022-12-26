import { CustomerService } from './../../service/customer.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, ElementRef, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  payModeList = ['Bank', 'Online', 'Scrarch Card']
  isProgressing = false;
  paymentForm!: FormGroup;
  constructor(
    private _formBuilder: FormBuilder,
    private _elementRef: ElementRef,
    private _customerService: CustomerService,
    private _router: Router,
    private _route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.createFrom();
    const accNo = this._route.snapshot.paramMap.get('accNo');
    this.paymentForm.patchValue({ customer: { accNo: accNo } });
  }

  createFrom() {
    this.paymentForm = this._formBuilder.group({
      customer: this._formBuilder.group({
        accNo: [{ value: '' }]
      }),
      amount: ['', [Validators.required]],
      paidOn: ['', [Validators.required]],
      description: ['', [Validators.required]],
      payMode: ['', [Validators.required]]
    })
  }

  submitForm() {
    this.isProgressing = true;
    if (this.paymentForm.valid) {
      this._customerService.createPaymet(this.paymentForm.value).subscribe(
        response => {
          this._router.navigate([`customers/${this.paymentForm.value.customer.accNo}/payments/view`]);
        },
        error => {
          console.log(error);
        }
      ).add(() => this.isProgressing = false);
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
    this.paymentForm.reset();
    this._elementRef.nativeElement.querySelector('#course-name').scrollIntoView();
  }
}
