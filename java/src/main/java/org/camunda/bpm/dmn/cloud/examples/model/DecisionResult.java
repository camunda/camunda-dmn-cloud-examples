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

package org.camunda.bpm.dmn.cloud.examples.model;

import java.util.List;
import java.util.Map;

public class DecisionResult {

  private Map<String, VariableValues> outputs;
  private List<MatchedRule> rules;
  private Double collectResult;

  public Map<String, VariableValues> getOutputs() {
    return outputs;
  }

  public void setOutputs(Map<String, VariableValues> outputs) {
    this.outputs = outputs;
  }

  public List<MatchedRule> getRules() {
    return rules;
  }

  public void setRules(List<MatchedRule> rules) {
    this.rules = rules;
  }

  public Double getCollectResult() {
    return collectResult;
  }

  public void setCollectResult(Double collectResult) {
    this.collectResult = collectResult;
  }

  public String toString() {
    return "DecisionResult{" +
      "outputs=" + outputs +
      ", rules=" + rules +
      ", collectResult=" + collectResult +
      '}';
  }

}
