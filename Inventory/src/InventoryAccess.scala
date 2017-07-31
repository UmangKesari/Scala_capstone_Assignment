package InventoryService

import InventoryModules.{Inventory, ItemDescription, ItemPrice}
import scala.concurrent.Future

trait InventoryAccess
{

  def sortByPrice(inventory: Inventory, category: String, itemName: String,
                  sortIn: String): Future[List[ItemDescription]] = {
    Future {
      if(sortIn.equalsIgnoreCase("price low to high")) {
        inventory.itemsList.filter(_.category == category).sortBy(_.price)
      }
      else if(sortIn.equalsIgnoreCase("price high to low")) {
        inventory.itemsList.filter(_.category == category).sortBy(_.price).reverse
      }
      else{
        inventory.itemsList.filter(_.category == category)
      }
    }
  }

  def getPrice(inventory: Inventory, itemID: String): Future[ItemPrice] = Future{
    inventory.itemsList.filter(_.itemId == itemID)(-1).price
  }

  }

}