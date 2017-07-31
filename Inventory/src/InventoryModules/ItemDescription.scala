package InventoryModules

import java.util.Locale.Category

case class ItemDescription(itemId : String, itemName : String, category : String,
                           vendorName : ItemVendorDetails, aboutItem : String, price : Double)
