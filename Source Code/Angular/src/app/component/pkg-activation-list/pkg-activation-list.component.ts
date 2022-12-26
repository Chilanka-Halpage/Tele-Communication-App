import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-pkg-activation-list',
  templateUrl: './pkg-activation-list.component.html',
  styleUrls: ['./pkg-activation-list.component.css']
})
export class PkgActivationListComponent implements OnInit {

  accNo: any;
  isLoadingResults = true;
  displayedColumns: string[] = [
    'refNo',
    'pkgName',
    'charge',
    'tax',
    'description',
    'status',
    'activatedOn',
    'deactivatedOn',
    'action'
  ];
  public dataSource!: MatTableDataSource<any>;
  constructor(
    private _customerService: CustomerService,
    private _route: ActivatedRoute,
    private _router: Router
  ) { }

  ngOnInit(): void {
    this.accNo = this._route.snapshot.paramMap.get('accNo');
    this.pkgsActivatedList(this.accNo);
  }

  pkgsActivatedList(accNo: any) {
    this._customerService.getPkgActivations(accNo).subscribe(response => {
      this.dataSource = new MatTableDataSource(response);
    }, error => {
      console.log(error);
    }).add(() => this.isLoadingResults = false)
  }
  onDeactivate(refNo: any) {
    this._customerService.deactivatePkgActivations(refNo).subscribe(response => {
      this.pkgsActivatedList(this.accNo);
    }, error => {
      console.log(error);
    })
  }
  onCreate() {
    this._router.navigate([`customers/${this.accNo}/pkgs/new`]);
  }

}
