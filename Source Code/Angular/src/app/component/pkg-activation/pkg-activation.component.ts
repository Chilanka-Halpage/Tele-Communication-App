import { Component, ElementRef, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-pkg-activation',
  templateUrl: './pkg-activation.component.html',
  styleUrls: ['./pkg-activation.component.css']
})
export class PkgActivationComponent implements OnInit {

  pkgActivationForm!: FormGroup;
  isProgressing = false;

  constructor(
    private _formBuilder: FormBuilder,
    private _elementRef: ElementRef,
    private _customerService: CustomerService,
    private _router: Router,
    private _route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.createForm();
    const accNo = this._route.snapshot.paramMap.get('accNo');
    this.pkgActivationForm.patchValue({ customer: { accNo: accNo } });
  }
  private createForm(): void {
    this.pkgActivationForm = this._formBuilder.group({
      customer: this._formBuilder.group({
        accNo: [{ value: '' }]
      }),
      packageName: ['', [Validators.required]],
      description: ['', [Validators.required]],
      charge: ['', [Validators.required]],
      tax: ['', [Validators.required]],
      active: ['true', [Validators.required]]
    });
  }

  submitForm() {
    this.isProgressing = true;
    if (this.pkgActivationForm.valid) {
      this._customerService.createPkgActivation(this.pkgActivationForm.value).subscribe(
        response => {
          this._router.navigate([`customers/${this.pkgActivationForm.value.customer.accNo}/pkgs/view`]);
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
    this.pkgActivationForm.reset();
    this._elementRef.nativeElement.querySelector('#course-name').scrollIntoView();
  }

}
