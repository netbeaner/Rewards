package rewards

import grails.transaction.Transactional

@Transactional
class CalculationsService {

    def welcome(params) {
		
		def fistname = params.fistname
		def totalPoints = params.totalPoints.toInteger()
		def welcomeMessage = ""
		
		switch(totalPoints){
			case 5:
				welcomeMessage = "$fistname, you have gotten $totalPoints"
				break
			case 4:
				welcomeMessage = "$fistname, You dont have 5 points. $totalPoints gotten"
				break
			case 0..3:
				welcomeMessage = "You have less than 4 points. $totalPoints gotten"
				break
			default:
				welcomeMessage = "You have more than 5 points. $totalPoints gotten"
		}
		
		return welcomeMessage

    }
	
	def getTotalPoints(customerInstance){
		def totalAwards = 0
		
		customerInstance.awards.each{
			totalAwards = totalAwards + it.points 
		}
		
		customerInstance.totalPoints = totalAwards
		
		return customerInstance
	}
	
	def processCheckin(Customer lookupInstance){
		
		def customerInstance = Customer.findByPhone(lookupInstance.phone)
		
		if(customerInstance == null) {
			customerInstance = lookupInstance
			customerInstance.firstName = "Customer"
			customerInstance.lastName = "customer lastname"
		}
		
		def totalAwards = 0
		
		customerInstance.awards.each{
			totalAwards = totalAwards + it.points
		}
		
		customerInstance.totalPoints = totalAwards
		def welcomeMessage = ""
		switch(totalAwards){
			case 5:
				welcomeMessage = "Welcome back $customerInstance.firstName, this drink is on us"
				break
			case 4:
				welcomeMessage = "Welcome back $customerInstance.firstName, Yor next drink is free"
				break
			case 1..3:
				welcomeMessage = "Welcome back  $customerInstance.firstName. You now have ${totalAwards+1} points"
				break
			default:
				welcomeMessage = "Welcome $customerInstance.firstName. Thank you for registering"
		}
		
		
		if(totalAwards < 5){
			customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Purchase", points: 1))
		}else{
		customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Reward", points: -5))
		}
		
		
		customerInstance.save(flush:true)	
		
		
		return [customerInstance, welcomeMessage]
	}
}
