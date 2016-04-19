package rewards

class InventoryController {

    def index() {
		render "texto mostrado desde index"
	}
	
	def edit(){
		def productName = "Breakfast Blend"
		def sku = "BB01"
		[product: productName, sku: sku]
	}
	
	def remove(){
		render "texto de remove"
	}
	
	def list(){
		def allProducts = Product.list()
		[allProducts: allProducts]
	}
}
