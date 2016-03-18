/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.bpm.dmn.cloud.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.ws.rs.core.MediaType;

import org.camunda.bpm.dmn.cloud.examples.model.DecisionResult;
import org.camunda.bpm.dmn.cloud.examples.model.VariableValue;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class DishDecision {

  public static void main(final String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("What Season is it? (Spring, Summer, Fall, Winter)  ");
    String season = scanner.nextLine().trim();

    System.out.print("How many Guests?  ");
    Integer guests = scanner.nextInt();

    ClientConfig clientConfig = new DefaultClientConfig();
    clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
    Client client = Client.create(clientConfig);

    Map<String, VariableValue> variables = new HashMap<String, VariableValue>();
    variables.put("season", new VariableValue("string", season));
    variables.put("guests", new VariableValue("integer", guests));

    WebResource resource = client.resource("https://dmn.camunda.cloud/api/v1/decision/example-dish");
    ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, variables);
    DecisionResult decisionResult = response.getEntity(DecisionResult.class);

    String result = (String) decisionResult.getOutputs().get("dish").getValues().get(0);
    System.out.println("You should have " + result);
  }

}
