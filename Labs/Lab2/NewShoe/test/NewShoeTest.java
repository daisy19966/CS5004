import static org.junit.jupiter.api.Assertions.*;
class NewShoeTest {

  @org.junit.jupiter.api.Test
  void getType() {
    NewShoe shoe = new NewShoe(ShoeType.SNEAKER, ShoeColor.RED, ShoeBrand.NIKE, 10);
    // Assertion 1: Check the type is as expected
    assertEquals(ShoeType.SNEAKER, shoe.getType(), "Expected shoe type to be SNEAKER");
    // Assertion 2: Ensure type is not DRESS
    assertNotEquals(ShoeType.DRESS, shoe.getType(), "Expected shoe type to not be DRESS");
  }

  @org.junit.jupiter.api.Test
  void getColor() {
    NewShoe shoe = new NewShoe(ShoeType.SNEAKER, ShoeColor.RED, ShoeBrand.NIKE, 10);
    // Assertion 1: Check color is correct
    assertEquals(ShoeColor.RED, shoe.getColor(), "Expected shoe color to be RED");
    // Assertion 2: Ensure color is not BLUE
    assertNotEquals(ShoeColor.BROWN, shoe.getColor(), "Expected shoe color to not be BROWN");
  }

  @org.junit.jupiter.api.Test
  void getBrand() {
    NewShoe shoe = new NewShoe(ShoeType.SNEAKER, ShoeColor.RED, ShoeBrand.NIKE, 10);
    // Assertion 1: Check brand is NIKE
    assertEquals(ShoeBrand.NIKE, shoe.getBrand(), "Expected shoe brand to be NIKE");
    // Assertion 2: Ensure brand is not ADIDAS
    assertNotEquals(ShoeBrand.ADIDAS, shoe.getBrand(), "Expected shoe brand to not be ADIDAS");
  }

  @org.junit.jupiter.api.Test
  void getSize() {
    NewShoe shoe = new NewShoe(ShoeType.SNEAKER, ShoeColor.RED, ShoeBrand.NIKE, 10);
    // Assertion 1: Check if the size is 10
    assertEquals(10, shoe.getSize(), "Expected shoe size to be 10");
    // Assertion 2: Ensure the size is not 12
    assertNotEquals(12, shoe.getSize(), "Expected shoe size to not be 12");
  }

  @org.junit.jupiter.api.Test
  void getSummary() {
    NewShoe shoe = new NewShoe(ShoeType.SNEAKER, ShoeColor.RED, ShoeBrand.NIKE, 10);
    String expectedSummary = "Shoe [Type: SNEAKER, Color: RED, Brand: NIKE, Size: 10.0]";
    // Assertion 1: Check if summary matches expected
    assertEquals(expectedSummary, shoe.getSummary(), "Expected summary to match the shoe's attributes");
    // Assertion 2: Check if the summary contains the brand "NIKE"
    assertTrue(shoe.getSummary().contains("NIKE"), "Summary should contain brand NIKE");
  }
}