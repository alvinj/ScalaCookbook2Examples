package r07_limit_by_inheritance

// pp. 197-198
package t1 {
  trait Employee
  class CorporateEmployee extends Employee
  class StoreEmployee     extends Employee

  trait DeliversFood extends StoreEmployee

  // this is allowed
  class DeliveryPerson extends StoreEmployee, DeliversFood

  // the following line will not compile
  // class Receptionist extends CorporateEmployee, DeliversFood
}
