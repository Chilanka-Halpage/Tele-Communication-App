import { CustomerService } from './../../service/customer.service';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  isLoadingResults = true;
  displayedColumns: string[] = [
    'accNo',
    'name',
    'NIC',
    'contactNo',
    'address',
    'action'
  ];
  public dataSource!: MatTableDataSource<any>;
  constructor(
    private _customerService: CustomerService,
    private _router: Router
  ) { }

  ngOnInit(): void {
    this.loadCustomerList();
  }

  loadCustomerList() {
    this._customerService.getCustomers().subscribe(response => {
      this.dataSource = new MatTableDataSource(response);
    }, error => {
      console.log(error);
    }).add(() => this.isLoadingResults = false)
  }

  onEdit(accNo: number): void {
    console.log(accNo);
    this._router.navigate(['customers/edit', accNo]);
  }

  onSelectPayments(accNo: any): void {
    this._router.navigate([`customers/${accNo}/payments/view`]);
  }

  onSelectPackages(accNo: any): void {
    this._router.navigate([`customers/${accNo}/pkgs/view`]);
  }

  onDelete(accNo: number): void {
    this._customerService.deleteCustomer(accNo).subscribe(response => {
      this.loadCustomerList();
    }, error => {
      console.log(error);
    });
  }
  onCreate() {
    this._router.navigate([`customers/new`]);
  }
}
