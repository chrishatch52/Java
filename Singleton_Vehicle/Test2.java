//=============================================================================================================================================================
public class Test2
{
   private static final String[] POWERPLANT_IDS =
   { "PowerplantTurboshaft", "PowerplantTurbojet", "PowerplantTurbofan", "PowerplantReciprocatingGas", "PowerplantReciprocatingDiesel", "PowerplantNuclear",
         "PowerplantElectric", "PowerplantGasTurbine" };

   private static int points = 0;

   public static void main(final String[] arguments)
   {

      System.out.println("Testing");

      Test2 test = new Test2();

      test.doTestSingleton();

      test.doTestPowerplantActionsAllowed();

      test.doTestPowerplantActionsDisallowed();

      test.testAircraftCommercialAirliner();
      test.testAircraftFighterJet();
      test.testAircraftHelicopter();
      test.testAircraftTrainer();
      test.testShipAircraftCarrier();
      test.testShipDestroyer();
      test.testShipSpeedboat();
      test.testShipYacht();
      test.testSubmarineVirginiaClass();

      test.testSubmarineUBoot();

      System.out.println("\nScore: " + points + "/217");
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   public void doTestPowerplantActionsAllowed()
   {
      System.out.println();
      System.out.println("TEST POWERPLANT ACTIONS ALLOWED");

      A_Powerplant[] powerplants = generatePowerplants("");

      for (int iPowerplant = 0; iPowerplant < POWERPLANT_IDS.length; ++iPowerplant)
      {
         A_Powerplant powerplant = powerplants[iPowerplant];

         String idExpected = POWERPLANT_IDS[iPowerplant];
         String idActual = powerplant.getID();

         System.out.println("pass? " + (idExpected.equals(idActual)) + "  idExpected=[" + idExpected + "]" + " idActual=[" + idActual + "]");

         if (idExpected.equals(idActual))
         {
            points++;
         }
      }

      System.out.println();

      String[] actions =
      { "spinning a shaft", "exhausting a jet", "bypassing lots of air", "vroom vroom!", "chattering away", "splitting atoms", "generating electricity",
            "spinning a gas turbine" };

      for (int iPowerplant = 0; iPowerplant < POWERPLANT_IDS.length; ++iPowerplant)
      {
         A_Powerplant powerplant = powerplants[iPowerplant];

         String actionExpected = actions[iPowerplant];
         String actionActual = powerplant.generate();

         System.out.println("pass? " + (actionExpected.equals(actionActual)) + "  actionExpected=[" + actionExpected + "]" + " actionActual=[" + actionActual
               + "]");

         if (actionExpected.equals(actionActual))
         {
            points++;
         }
      }

      System.out.println();

      for (int iPowerplant = 0; iPowerplant < POWERPLANT_IDS.length; ++iPowerplant)
      {
         A_Powerplant powerplant = powerplants[iPowerplant];

         boolean hostExpected = false;
         boolean hostActual = powerplant.hasHost();

         System.out.println("pass? " + (hostExpected == hostActual) + "  hostExpected=[" + hostExpected + "]" + " hostActual=[" + hostActual + "]");

         if (hostExpected == hostActual)
         {
            points++;
         }

      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   public void doTestPowerplantActionsDisallowed()
   {
      System.out.println();
      System.out.println("TEST POWERPLANT ACTIONS DISALLOWED");

      System.out.println();
      System.out.println(" GET NONEXISTENT HOST");

      A_Powerplant[] powerplants = generatePowerplants("A");

      for (A_Powerplant powerplant : powerplants)
      {
         try
         {
            powerplant.getHost();

            System.out.println("pass? false");
         }
         catch (Exception exception)
         {
            System.out.println("pass? true  " + exception.getMessage());
            points++;
         }
      }

      System.out.println();
      System.out.println(" REMOVE NONEXISTENT HOST");

      for (A_Powerplant powerplant : powerplants)
      {
         try
         {
            powerplant.removeHost();

            System.out.println("pass? false");
         }
         catch (Exception exception)
         {
            System.out.println("pass? true  " + exception.getMessage());
            points++;
         }
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   public void doTestSingleton()
   {
      IdentifierSaltManager manager1 = IdentifierSaltManager.getInstance();
      IdentifierSaltManager manager2 = IdentifierSaltManager.getInstance();

      int identity1 = System.identityHashCode(manager1);
      int identity2 = System.identityHashCode(manager2);

      System.out.println();
      System.out.println("TEST SINGLETON");
      System.out.println("pass? " + (identity1 == identity2) + "  firstaccess=" + identity1 + " secondaccess=" + identity2);

      if (identity1 == identity2)
      {
         points++;
      }

      String idSalted1 = manager1.getIDSalted("myID");
      String idSalted2 = manager1.getIDSalted("myID");

      System.out.println("pass? " + idSalted1.equals("myID#1") + "  idSalted1=" + idSalted1);

      if (idSalted1.equals("myID#1"))
      {
         points++;
      }

      System.out.println("pass? " + idSalted2.equals("myID#2") + "  idSalted2=" + idSalted2);

      if (idSalted2.equals("myID#2"))
      {
         points++;
      }

      int saltNext1 = manager1.getSaltNext();
      int saltNext2 = manager1.getSaltNext();

      System.out.println("pass? " + (saltNext1 == 3) + "  saltNext1=" + saltNext1);

      if (saltNext1 == 3)
      {
         points++;
      }

      System.out.println("pass? " + (saltNext2 == 3) + "  saltNext2=" + saltNext1);

      if (saltNext2 == 3)
      {
         points++;
      }

   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private A_Powerplant[] generatePowerplants(final String suffix)
   {
      assert (suffix != null);

      return new A_Powerplant[]
      { new PowerplantTurboshaft(POWERPLANT_IDS[0] + suffix), new PowerplantTurbojet(POWERPLANT_IDS[1] + suffix),
            new PowerplantTurbofan(POWERPLANT_IDS[2] + suffix), new PowerplantReciprocatingGas(POWERPLANT_IDS[3] + suffix),
            new PowerplantReciprocatingDiesel(POWERPLANT_IDS[4] + suffix), new PowerplantNuclear(POWERPLANT_IDS[5] + suffix),
            new PowerplantElectric(POWERPLANT_IDS[6] + suffix), new PowerplantGasTurbine(POWERPLANT_IDS[7] + suffix) };
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void testAircraftCommercialAirliner()
   {
      A_Powerplant[] powerplants =
      { new PowerplantTurboshaft("MyPowerplantTurboshaft"), new PowerplantTurbofan("MyPowerplantTurbofan") };

      String id = "MyCommercialAirliner";

      for (A_Powerplant powerplant : powerplants)
      {
         A_Vehicle vehicle = new AircraftCommercialAirliner(id, powerplant);

         testVehicle("testAircraftCommercialAirliner", id, vehicle, powerplant);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void testAircraftFighterJet()
   {
      A_Powerplant[] powerplants =
      { new PowerplantTurbojet("MyPowerplantTurbojet"), new PowerplantTurbofan("MyPowerplantTurbofan") };

      String id = "MyAircraftFighterJet";

      for (A_Powerplant powerplant : powerplants)
      {
         A_Vehicle vehicle = new AircraftFighterJet(id, powerplant);

         testVehicle("testAircraftFighterJet", id, vehicle, powerplant);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void testAircraftHelicopter()
   {
      A_Powerplant[] powerplants =
      { new PowerplantTurboshaft("MyPowerplantTurboshaft"), new PowerplantReciprocatingGas("MyPowerplantReciprocatingGas") };

      String id = "MyAircraftHelicopter";

      for (A_Powerplant powerplant : powerplants)
      {
         A_Vehicle vehicle = new AircraftHelicopter(id, powerplant);

         testVehicle("testAircraftHelicopter", id, vehicle, powerplant);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void testAircraftTrainer()
   {
      A_Powerplant[] powerplants =
      { new PowerplantReciprocatingGas("MyPowerplantReciprocatingGas"), new PowerplantReciprocatingDiesel("MyPowerplantReciprocatingDiesel") };

      String id = "MyAircraftTrainer";

      for (A_Powerplant powerplant : powerplants)
      {
         A_Vehicle vehicle = new AircraftTrainer(id, powerplant);

         testVehicle("testAircraftTrainer", id, vehicle, powerplant);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void testShipAircraftCarrier()
   {
      A_Powerplant[] powerplants =
      { new PowerplantNuclear("MyPowerplantNuclear") };

      String id = "MyShipAircraftCarrier";

      for (A_Powerplant powerplant : powerplants)
      {
         A_Vehicle vehicle = new ShipAircraftCarrier(id, powerplant);

         testVehicle("testShipAircraftCarrier", id, vehicle, powerplant);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void testShipDestroyer()
   {
      A_Powerplant[] powerplants =
      { new PowerplantGasTurbine("MyPowerplantGasTurbine") };

      String id = "MyShipDestroyer";

      for (A_Powerplant powerplant : powerplants)
      {
         A_Vehicle vehicle = new ShipDestroyer(id, powerplant);

         testVehicle("testShipDestroyer", id, vehicle, powerplant);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void testShipSpeedboat()
   {
      A_Powerplant[] powerplants =
      { new PowerplantTurboshaft("MyPowerplantTurboshaft"), new PowerplantReciprocatingGas("MyPowerplantReciprocatingGas") };

      String id = "MyShipSpeedboat";

      for (A_Powerplant powerplant : powerplants)
      {
         A_Vehicle vehicle = new ShipSpeedboat(id, powerplant);

         testVehicle("testShipSpeedboat", id, vehicle, powerplant);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void testShipYacht()
   {
      A_Powerplant[] powerplants =
      { new PowerplantReciprocatingGas("MyPowerplantReciprocatingGas"), new PowerplantReciprocatingDiesel("MyPowerplantReciprocatingDiesel") };

      String id = "MyShipYacht";

      for (A_Powerplant powerplant : powerplants)
      {
         A_Vehicle vehicle = new ShipYacht(id, powerplant);

         testVehicle("testShipYacht", id, vehicle, powerplant);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void testSubmarineUBoot()
   {
      // WRITE YOUR OWN TESTS HERE BASED ON THE SPECS
      // CHECK FOR {PRIMARY,SECONDARY} X {PRESENT,ABSENT} COMBINATIONS
      // CHECK FOR PRIMARY == SECONDARY ERROR

      String id = "MySubmarineUBoot";

      A_Powerplant powerplant1 = new PowerplantElectric("PowerplantElectric");
      A_Powerplant powerplant2 = new PowerplantReciprocatingDiesel("PowerplantReciprocatingDiesel");

      SubmarineUBoot sub = new SubmarineUBoot(id, powerplant1, powerplant2);

      System.out.println();
      System.out.println(" VEHICLE TEST: testSubmarineUBoot:: " + sub.getClass().getSimpleName() + " with " + powerplant1.getClass().getSimpleName() + " and "
            + powerplant2.getClass().getSimpleName());

      String idtested = sub.getID();
      String idSalted = sub.getIDSalted();

      System.out.println("id      =" + idtested);
      System.out.println("idSalted=" + idSalted);

      sub.move();

      boolean hasPowerplantPrimary = sub.hasPowerplantPrimary();
      System.out.println("pass? " + hasPowerplantPrimary + "  hasPowerplantPrimary()");

      if (hasPowerplantPrimary)
      {
         points++;
      }

      boolean hasPowerplantSecondary = sub.hasPowerplantSecondary();
      System.out.println("pass? " + hasPowerplantSecondary + "  hasPowerplantSecondary()");

      if (hasPowerplantSecondary)
      {
         points++;
      }

      boolean hasHost1 = powerplant1.hasHost();
      System.out.println("pass? " + hasHost1 + "  primary.hasHost()");

      if (hasHost1)
      {
         points++;
      }

      boolean hasHost2 = powerplant2.hasHost();
      System.out.println("pass? " + !hasHost2 + "  secondary.hasHost()");

      if (!hasHost2)
      {
         points++;
      }

      A_Powerplant powerplantPrimaryGetted = sub.getPowerplantPrimary();
      System.out.println("pass? " + (powerplantPrimaryGetted == powerplant1) + "  getPowerplantPrimary()");

      if (powerplantPrimaryGetted == powerplant1)
      {
         points++;
      }

      A_Powerplant powerplantSecondaryGetted = sub.getPowerplantSecondary();
      System.out.println("pass? " + (powerplantSecondaryGetted == powerplant2) + "  getPowerplantSecondary()");

      if (powerplantSecondaryGetted == powerplant2)
      {
         points++;
      }

      try
      {
         sub.installPowerplantPrimary(powerplant1);

         System.out.println("pass? false  installPowerplantPrimary()");
      }
      catch (Exception exception)
      {
         System.out.println("pass? true  installPowerplantPrimary()");
         points++;
      }

      try
      {
         sub.installPowerplantSecondary(powerplant2);

         System.out.println("pass? false  installPowerplantSecondary()");
      }
      catch (Exception exception)
      {
         System.out.println("pass? true  installPowerplantSecondary()");
         points++;
      }

      boolean hasHost3 = powerplant1.hasHost();
      System.out.println("pass? " + hasHost3 + "  primary.hasHost()");

      if (hasHost3)
      {
         points++;
      }

      boolean hasHost4 = powerplant1.hasHost();
      System.out.println("pass? " + hasHost4 + "  secondary.hasHost()");

      if (hasHost4)
      {
         points++;
      }

      A_Vehicle host1 = powerplant1.getHost();
      System.out.println("pass? " + (host1 == sub) + "  primary.getHost()");

      if (host1 == sub)
      {
         points++;
      }

      try
      {
         powerplant2.getHost();

         System.out.println("pass? false  secondary.getHost()");
      }
      catch (Exception exception)
      {
         System.out.println("pass? true  secondary.getHost()");
         points++;
      }

      boolean isPrimaryOrSecondary = sub.isPrimaryOrSecondary();
      System.out.println("pass? " + isPrimaryOrSecondary + "  isPrimaryOrSecondary()");

      if (isPrimaryOrSecondary)
      {
         points++;
      }

      sub.isPrimaryOrSecondary(false);
      isPrimaryOrSecondary = sub.isPrimaryOrSecondary();
      System.out.println("pass? " + !isPrimaryOrSecondary + "  isPrimaryOrSecondary()");

      if (!isPrimaryOrSecondary)
      {
         points++;
      }

      sub.removePowerplantPrimary();
      boolean hasPowerplant2 = sub.hasPowerplantPrimary();
      System.out.println("pass? " + !hasPowerplant2 + "  hasPowerplantPrimary()");

      if (!hasPowerplant2)
      {
         points++;
      }

      try
      {
         sub.removePowerplantSecondary();

         System.out.println("pass? false  removePowerplantSecondary()");

      }
      catch (Exception exception)
      {
         System.out.println("pass? true  removePowerplantSecondary()");
         points++;
      }

      try
      {
         sub.getPowerplantPrimary();

         System.out.println("pass? false  getPowerplantPrimary()");
      }
      catch (Exception exception)
      {
         System.out.println("pass? true  getPowerplantPrimary()");
         points++;
      }

      try
      {
         sub.getPowerplantSecondary();

         System.out.println("pass? true  getPowerplantSecondary()");
         points++;
      }
      catch (Exception exception)
      {
         System.out.println("pass? false  getPowerplantSecondary()");
      }

      try
      {
         sub.removePowerplantPrimary();

         System.out.println("pass? false  removePowerplantPrimary()");
      }
      catch (Exception exception)
      {
         System.out.println("pass? true  removePowerplantPrimary()");
         points++;
      }

      try
      {
         sub.removePowerplantSecondary();

         System.out.println("pass? false  removePowerplantSecondary()");
      }
      catch (Exception exception)
      {
         System.out.println("pass? true  removePowerplantSecondary()");
         points++;
      }

      try
      {
         powerplant1.getHost();

         System.out.println("pass? false  primary.getHost()");
      }
      catch (Exception exception)
      {
         System.out.println("pass? true  primary.getHost()");
         points++;
      }

      try
      {
         powerplant2.getHost();

         System.out.println("pass? false  secondary.getHost()");
      }
      catch (Exception exception)
      {
         System.out.println("pass? true  secondary.getHost()");
         points++;
      }

   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void testSubmarineVirginiaClass()
   {
      A_Powerplant[] powerplants =
      { new PowerplantNuclear("MyPowerplantNuclear") };

      String id = "MySubmarineVirginiaClass";

      for (A_Powerplant powerplant : powerplants)
      {
         A_Vehicle vehicle = new SubmarineVirginiaClass(id, powerplant);

         testVehicle("testSubmarineVirginiaClass", id, vehicle, powerplant);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void testVehicle(final String testName, final String idExpected, final A_Vehicle vehicle, final A_Powerplant powerplantExpected)
   {
      assert (testName != null);
      assert (idExpected != null);
      assert (vehicle != null);
      assert (powerplantExpected != null);

      System.out.println();
      System.out.println(" VEHICLE TEST: " + testName + ":: " + vehicle.getClass().getSimpleName() + " with " + powerplantExpected.getClass().getSimpleName());

      String id = vehicle.getID();
      String idSalted = vehicle.getIDSalted();

      System.out.println("id      =" + id);
      System.out.println("idSalted=" + idSalted);

      vehicle.move();

      boolean hasPowerplant1 = vehicle.hasPowerplant();

      System.out.println("pass? " + hasPowerplant1 + "  hasPowerplant()");

      if (hasPowerplant1)
      {
         points++;
      }

      boolean hasHost1 = powerplantExpected.hasHost();

      System.out.println("pass? " + hasHost1 + "  hasHost()");

      if (hasHost1)
      {
         points++;
      }

      A_Powerplant powerplantGetted = vehicle.getPowerplant();

      System.out.println("pass? " + (powerplantGetted == powerplantExpected) + "  getPowerplant()");

      if (powerplantGetted == powerplantExpected)
      {
         points++;
      }

      try
      {
         vehicle.installPowerplant(powerplantExpected);

         System.out.println("pass? false  installPowerplant()");
      }
      catch (Exception exception)
      {
         System.out.println("pass? true  installPowerplant()");
         points++;
      }

      boolean hasHost2 = powerplantExpected.hasHost();

      System.out.println("pass? " + hasHost2 + "  hasHost()");

      if (hasHost2)
      {
         points++;
      }

      A_Vehicle host1 = powerplantExpected.getHost();

      System.out.println("pass? " + (host1 == vehicle) + "  getHost()");

      if (host1 == vehicle)
      {
         points++;
      }

      vehicle.removePowerplant();

      boolean hasPowerplant2 = vehicle.hasPowerplant();

      System.out.println("pass? " + !hasPowerplant2 + "  hasPowerplant()");

      if (!hasPowerplant2)
      {
         points++;
      }

      try
      {
         vehicle.getPowerplant();

         System.out.println("pass? false  getPowerplant()");
      }
      catch (Exception exception)
      {
         System.out.println("pass? true  getPowerplant()");
         points++;
      }

      try
      {
         vehicle.removePowerplant();

         System.out.println("pass? false  removePowerplant()");
      }
      catch (Exception exception)
      {
         System.out.println("pass? true  removePowerplant()");
         points++;
      }

      try
      {
         powerplantExpected.getHost();

         System.out.println("pass? false  getHost()");
      }
      catch (Exception exception)
      {
         System.out.println("pass? true  getHost()");
         points++;
      }
   }
}
