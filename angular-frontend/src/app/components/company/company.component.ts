import {Component, OnInit} from '@angular/core';
import {CompanyService} from '../../services/company.service';
import {Company} from '../../models/company';
import {Router} from '@angular/router';
import {CompRightNormService} from '../../services/comp-right-norm.service';
import {ServiceSectionService} from '../../services/service-section.service';
import {ServiceClassService} from '../../services/service-class.service';
import {AddressService} from '../../services/address.service';
import {CompRightNorm} from '../../models/comp-right-norm';
import {Address} from '../../models/address';
import {ServiceSection} from '../../models/ss';
import {ServiceClass} from '../../models/sc';


@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})

export class CompanyComponent implements OnInit {

  private compServ: CompanyService;
  private addressServ: AddressService;
  private crnServ: CompRightNormService;
  private ssServ: ServiceSectionService;
  private scServ: ServiceClassService;
  private router: Router;

  companies: Company[];
  crn: CompRightNorm[];
  address: Address[];
  ss: ServiceSection[];
  sc: ServiceClass[];

  selectedCompanyValue: Company;
  selectedAddressValue: Address;
  selectedSSValue: ServiceSection;
  selectedCRNValue: CompRightNorm;

  phone: string;
  compName: string;
  changedAddressId: number;
  changedSSId: number;
  changedCRNId: number;

  // isLoading: boolean = false;

  constructor(cs: CompanyService,
              ad: AddressService,
              crn: CompRightNormService,
              ss: ServiceSectionService,
              sc: ServiceClassService,
              r: Router) {
    this.compServ = cs;
    this.addressServ = ad;
    this.crnServ = crn;
    this.ssServ = ss;
    this.scServ = sc;
    this.router = r;
  }

  ngOnInit(): void {
    this.reloadData();
  }

  private reloadData(): void {
    this.compServ.getCompaniesList().subscribe(value => {
      value = JSON.parse(value);
      this.companies = value as Company[];
      console.log(this.companies);
    });

    this.crnServ.getCompRightNormList().subscribe(value => {
      value = JSON.parse(value);
      this.crn = value as CompRightNorm[];
      //console.log(this.crn);
    });

    this.addressServ.getAddressesList().subscribe(value => {
      value = JSON.parse(value);
      this.address = value as Address[];
      //console.log(this.address);
    });
    this.ssServ.getServiceSectionList().subscribe(value => {
      value = JSON.parse(value);
      this.ss = value as ServiceSection[];
      //console.log(this.ss);
    });
    this.scServ.getServiceClassList().subscribe(value => {
      value = JSON.parse(value);
      this.sc = value as ServiceClass[];
      //console.log(this.sc);
    });
  }

  getCompanyById(id: number): any {
    return this.compServ.getCompanyById(id);
  }

  deleteCompany(id: number): void {
    console.log(id);
    // this.isLoading = true;
    this.compServ.delCompanyById(id).subscribe(value => {
        const temp = this.companies.find(item => item.id === id);
        this.companies.forEach((item, index, array) => {
          if (item == temp) {
            array.splice(index, 1);
          }
        });
        // this.isLoading = false;

      }, error => console.error(error),
      () => {
        // this.isLoading = false;
      });

    //this.reloadData();

  }

  openAddModal(): void {
    this.selectedCompanyValue = new Company();

    this.compName = '';
    this.phone = '';

    this.changedAddressId = this.address[0].id;
    this.changedCRNId = this.crn[0].id;
    this.changedSSId = this.ss[0].id;
  }

  openEditModal(id: number): void {
    console.log(id);
    this.selectedCompanyValue = this.companies.find(value => value.id === id);

    this.compName = this.companies.find(value => value.id === id).name;
    this.phone = this.companies.find(value => value.id === id).phone;

    this.selectedAddressValue = this.companies.find(value => value.id === id).address;
    this.selectedSSValue = this.companies.find(value => value.id === id).serviceSection;
    this.selectedCRNValue = this.companies.find(value => value.id === id).compRightNorm;

    this.changedAddressId = this.selectedAddressValue.id;
    this.changedCRNId = this.selectedCRNValue.id;
    this.changedSSId = this.selectedSSValue.id;
  }

  saveChanges(): void {
    this.selectedCompanyValue.name = this.compName;
    this.selectedCompanyValue.phone = this.phone;
    this.selectedCompanyValue.address = this.address.find(value => value.id === this.changedAddressId);
    this.selectedCompanyValue.compRightNorm = this.crn.find(value => value.id === this.changedCRNId);
    this.selectedCompanyValue.serviceSection = this.ss.find(value => value.id === this.changedSSId);
    console.log(this.selectedCompanyValue);
    this.compServ.saveCompany(this.selectedCompanyValue).subscribe(value => {
      console.log(value);
      this.reloadData();
    });
  }

}
