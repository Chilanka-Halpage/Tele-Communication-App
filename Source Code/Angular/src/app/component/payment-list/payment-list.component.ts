import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-payment-list',
  templateUrl: './payment-list.component.html',
  styleUrls: ['./payment-list.component.css']
})
export class PaymentListComponent implements OnInit {
  accNo: any;
  isLoadingResults = true;
  displayedColumns: string[] = [
    'refNo',
    'amount',
    'payMode',
    'paidOn',
    'description',
  ];
  public dataSource!: MatTableDataSource<any>;
  constructor(
    private _customerService: CustomerService,
    private _route: ActivatedRoute,
    private _router: Router
  ) { }

  ngOnInit(): void {
    this.accNo = this._route.snapshot.paramMap.get('accNo');
    this.loadPaymentData(this.accNo);
  }

  loadPaymentData(accNo: any) {
    this._customerService.getPayments(accNo).subscribe(response => {
      this.dataSource = new MatTableDataSource(response);
    }, error => {
      console.log(error);
    }).add(() => this.isLoadingResults = false)
  }

  onCreate() {
    this._router.navigate([`customers/${this.accNo}/payments/new`]);
  }

}
