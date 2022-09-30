package r07_opaque_types


// p. 692

object DomainObjects:

    opaque type CustomerId = Int
    object CustomerId:
        def apply(i: Int): CustomerId = i
    given CanEqual[CustomerId, CustomerId] = CanEqual.derived

    opaque type ProductId = Int
    object ProductId:
        def apply(i: Int): ProductId = i
    given CanEqual[ProductId, ProductId] = CanEqual.derived


@main def OpaqueTypes = 
    // import the types
    import DomainObjects.*

    // use the `apply` methods
    val customerId = CustomerId(101)
    val productId = ProductId(101)

    // use the types
    def addToCart(customerId: CustomerId, productId: ProductId) = 
        println(s"Added customerId = $customerId")
        println(s"Added productId  = $productId")

    // pass the types to the function
    addToCart(customerId, productId)
    
    
    // the following code examples won’t compile, as desired

    // error: values of types DomainObjects.CustomerId and Int 
    // cannot be compared with == or !=
    // if customerId == 1000 then println("Huh, that compiled")

    // also an error: this code will not compile
    // if customerId == productId then println("Huh, that compiled")
    
    
    
    
    



