using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;

namespace DishDecisionExample
{
    class Program
    {
        static string URL = "https://dmn.camunda.cloud/api/v1/decision/example-dish";

        private static void Main(string[] args)
        {

            Console.Write("What Season is it? (Spring, Summer, Fall, Winter) ");
            string season = Console.ReadLine();

            Console.Write("How many Guests? ");
            int numberOfGuests = Int32.Parse(Console.ReadLine());

            string dish = evaluateDmn(season, numberOfGuests);

            Console.Write("Dish: " + dish + ". Press any key to exit.");
            Console.ReadLine();
        }

        private static string evaluateDmn(string season, int numberOfGuests)
        {
            HttpClient http = new HttpClient();
            http.BaseAddress = new Uri(URL);

            // Add an Accept header for JSON format.
            http.DefaultRequestHeaders.Accept.Add(
                     new MediaTypeWithQualityHeaderValue("application/json"));

            Dictionary<string, Variable> request = new Dictionary<string, Variable>();
            request.Add("input1", new Variable(season, "string"));
            request.Add("input2", new Variable(numberOfGuests, "integer"));

            HttpResponseMessage response = http.PostAsJsonAsync("", request).Result;
            if (response.IsSuccessStatusCode)
            {
                DecisionResult result = response.Content.ReadAsAsync<DecisionResult>().Result;
                return (string) result.outputs["output1"].values.First();
            }
            return null;
        }
    }

    public class Variable
    {
        public object value { get; set; }
        public string type { get; set; }
        public Variable(object value, string type)
        {
            this.value = value;
            this.type = type;
        }
    }

    public class VariableValues
    {

        public string type { get; set; }
        public List<object> values { get; set; }
    }

    public class DecisionResult
    {
        public Dictionary<string, VariableValues> outputs { get; set; }
        public List<MatchedRule> rules { get; set; }
        public double collectResult { get; set; }
    }

    public class MatchedRule
    {
        private string ruleId { get; set; }
        private Dictionary<string, Variable> outputs { get; set; }
    }
}
