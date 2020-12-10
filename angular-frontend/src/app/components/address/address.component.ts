import {Component, OnInit} from '@angular/core';
import {AddressService} from '../../services/address.service';
import {Router} from '@angular/router';
import {Address} from '../../models/address';
import {AddressJson} from '../../models/addressJson';

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css']
})
export class AddressComponent implements OnInit {

  private addressServ: AddressService;
  private router: Router;

  addresses: Address[];

  selectedAddressValue: Address;


  changedAddressId: number;
  city: string;
  street: string;
  house: string;
  office: string;


  constructor(ad: AddressService,
              r: Router) {
    this.addressServ = ad;
    this.router = r;
  }

  ngOnInit(): void {
    this.reloadData();
  }

  private reloadData(): void {
    this.addressServ.getAddressesList().subscribe(value => {
      value = JSON.parse(value);
      this.addresses = value as Address[];
      console.log(this.addresses);
    });
  }


  deleteAddress(id: number): void {
    console.log(id);
    // this.isLoading = true;
    this.addressServ.delAddressById(id).subscribe(value => {
        const temp = this.addresses.find(item => item.id === id);
        this.addresses.forEach((item, index, array) => {
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
    this.selectedAddressValue = new Address();
    this.selectedAddressValue.addressJsonb = new AddressJson();
    this.city = '';
    this.street = '';
    this.house = '';
    this.office = '';
  }

  openEditModal(id: number): void {
    console.log(id);
    this.selectedAddressValue = this.addresses.find(value => value.id === id);
    this.changedAddressId = this.selectedAddressValue.id;
    this.city = this.selectedAddressValue.addressJsonb.cityName;
    this.street = this.selectedAddressValue.addressJsonb.streetName;
    this.house = this.selectedAddressValue.addressJsonb.houseNumber;
    this.office = this.selectedAddressValue.addressJsonb.officeNumber;
    console.log(this.selectedAddressValue);
  }

  saveChanges(): void {
    this.selectedAddressValue.addressJsonb.cityName = this.city;
    this.selectedAddressValue.addressJsonb.streetName = this.street;
    this.selectedAddressValue.addressJsonb.houseNumber = this.house;
    this.selectedAddressValue.addressJsonb.officeNumber = this.office;

    console.log(this.selectedAddressValue);
    this.addressServ.saveAddress(this.selectedAddressValue).subscribe(value => {
      console.log(value);
      this.reloadData();
    });
  }

}
