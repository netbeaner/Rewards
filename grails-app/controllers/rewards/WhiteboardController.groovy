package rewards

class WhiteboardController {
	
	def calculationsService

    def index() { }
	
	def variables(){
		
		def myTotal = 1
		render(myTotal+1)
		
		def firstName = "Omar"
		render("</BR>"+firstName+1)
		
		def today = new Date()
		render("</BR>"+today)
		today = today + 1
		render("</BR>Mañana= "+today)
	}
	
	def strings(){
		def first = "Omar"
		def last = "Ortega"
		def pints = 4
		def today = new Date()
		
		render "Hi ${first.toUpperCase()} ${last.toLowerCase()}, you have $pints points at the date $today" 
	}
	
	def conditions(){
		def welcomeMessage = calculationsService.welcome(params)
		
		render welcomeMessage
	}
}
