package rewards

class CustomerController {

 static scaffold = true
 
 def calculationsService
 
 def lookup(){
	 //def customerInstance = Customer.list(sort:"firstName",order:"desc", max:5, offset:0) 
	 //def customerInstance = Customer.findAllByFirstName("Bo")
	 //def customerInstance = Customer.findByFirstName("Bo")
	 //def customerInstance = Customer.findAllByTotalPoints(3)
//	 def customerInstance = Customer.findAllByLastNameLike("B%")
//	 def customerInstance = Customer.findAllByLastNameILike("b%")
	 //def customerInstance = Customer.findAllByTotalPointsGreaterThan(3)
	 //def customerInstance = Customer.findAllByTotalPointsGreaterThanEquals(3,[sort:"totalPoints",order:"desc"])
//	 def customerInstance = Customer.findAllByTotalPointsBetween(2,4,[sort:"totalPoints"])
//	 def customerInstance = Customer.findAllByFirstNameAndTotalPoints("Bo",3)
	 //def customerInstance = Customer.findAllByFirstNameIlikeAndTotalPointsBetween("B%",2,4)
	 params.max = 10
	 //def customerInstance = Customer.list(params)
	 [customerInstanceList: Customer.list(params), customerInstanceCount:Customer.count()]
 }

def index() {
	
	params.max = 10

	[customerInstanceList: Customer.list(params), customerInstanceCount: Customer.count()]	
}

def create(){
	[customerInstance: new Customer()]
}

def save(Customer customerInstance){
	customerInstance.save()
	redirect(action:"show", id: customerInstance.id)
	
}

def show(Long id){
	def customerInstance = Customer.get(id)
	customerInstance = calculationsService.getTotalPoints(customerInstance)
	[customerInstance:customerInstance]
}

def edit(Long id){
	def customerInstance = Customer.get(id)
	[customerInstance:customerInstance]
}

def update(Long id){
	def customerInstance = Customer.get(id)
	customerInstance.properties = params
	customerInstance.save(flush:true)
	redirect(action:"show", id: customerInstance.id)
}

def delete(Long id){
	def customerInstance = Customer.get(id)
	customerInstance.delete(flush:true)
	redirect(action:"index")
}

def customerLookup(Customer lookupInstance){
	def (customerInstance, welcomeMessage) = calculationsService.processCheckin(lookupInstance)
	render(view:"checkin", model:[customerInstane: customerInstance, welcomeMessage: welcomeMessage])
}
 

 def checkin(){}
 
 def profile(){
	 def customerInstance = Customer.findByPhone(params.id)
	 [customerInstance: customerInstance]
 }
 
 def updateProfile(Customer customerInstance){
	 //customerInstance.save(flush:true)
	 render(view:"profile", model:[customerInstance: customerInstance])
	 
 }
}
