package r10_pizzastore


// pp. 308-309
enum Topping:
    case Cheese, Pepperoni, Sausage, Mushrooms, Onions

enum CrustSize:
    case Small, Medium, Large

enum CrustType:
    case Regular, Thin, Thick

case class Pizza(
    crustSize: CrustSize,
    crustType: CrustType,
    toppings: Seq[Topping]
)

case class Customer(
    name: String,
    phone: String,
    address: Address
)

case class Address(
    street1: String,
    street2: Option[String],
    city: String,
    state: String,
    postalCode: String
)

case class Order(
    pizzas: Seq[Pizza],
    customer: Customer
)



