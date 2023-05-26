@smoke
  Feature: User can add products to wishlist
  Scenario:User add product to wishlist, verify the success message
  When user click on wishlist button ❤️ on this product "HTC One M8 Android L 5.0 Lollipop"
  Then success message is displayed "The product has been added to your wishlist" with green background color


  Scenario:User add product to wishlist, verify it's added successfully
  When user click on wishlist button ❤️ on this product "HTC One M8 Android L 5.0 Lollipop"
  And after the success message disappear, click on Wishlist Tab on the top of the page
   Then get Qty value and verify it's bigger than zero
