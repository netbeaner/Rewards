package rewards

class Customer {
	String firstName
	String lastName
	Long phone
	String email
	Integer totalPoints
	static hasMany = [awards:Award, orders:OnlineOrder]

   static constraints = {
		phone()
		firstName(size:1..255)
		lastName(maxSize:255)
		email(nullable:true, email:true)
		totalPoints(max:10)
    }
}
