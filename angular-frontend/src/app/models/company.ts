import {ServiceSection} from './ss';
import {Address} from './address';
import {CompRightNorm} from './comp-right-norm';


export class Company {
  id: number;
  name: string;
  phone: string;
  address: Address;
  serviceSection: ServiceSection;
  compRightNorm: CompRightNorm;
}
