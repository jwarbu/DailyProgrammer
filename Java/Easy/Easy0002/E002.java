/**
 * Dog food calculator based on weight of dog and # of meals a day using
 * "ME (kcal/day) = 110 (body weight in kilograms)0.75 to maintain a typical adult dog"
 * Following petmd's standards:
 * http://www.petmd.com/blogs/nutritionnuggets/jcoates/2013/aug/how-many-calories-does-dog-need-30849
 * "Divide a dog’s body weight in pounds by 2.2 to convert to kilograms (kg)
 * Resting Energy Requirement (RER) = 70 (body weight in kg)^0.75
 * Maintenance Energy Requirement (MER) = appropriate multiplier x RER
 *
 * Commonly Used Multipliers (pick one)
 *
 * typical neutered pet: 1.6
 * typical intact pet: 1.8
 * weight loss: 1
 * weight gain: 1.7
 * light work: 2
 * moderate work: 3
 * heavy work: 6
 * growth (less than 4 months old): 3
 * growth (more than 4 months old): 2
 *
 * Here’s what the calculations look like for a neutered pet dog weighing 45 pounds that is at
 * his or her ideal weight.
 * 45 lbs / 2.2 = 20.5 kg
 * 70 x 20.5^0.75 = 674 kcal/day
 * 1.6 x 672 = 1075 kcal/day"
 */
public class E002
{
    public class Dog
    {
        private String name;
        private double weight_kg, weight_lb, multiplier;

        public Dog()
        {
            name = "n/a";
            weight_lb = -1;
            weight_kg = -1;
            multiplier = 1;
        }

        public Dog(String in_name, double in_weight, boolean isKilo, double in_multiplier)
        {
            name = in_name;
            multiplier = in_multiplier;

            if(isKilo)
            {
                weight_kg = in_weight;
            }

            else
            {
                weight_lb = in_weight;
                weight_kg = toKilo(weight_lb);
            }
        }


        private double toKilo(double w)
        {
            return weight_kg = w/2.2;
        }
    }

    public static void main(String[] args)
    {
        System.out.println("");
    }
}
