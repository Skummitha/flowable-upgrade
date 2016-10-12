package org.activiti.upgrade.test.helper;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.upgrade.helper.UpgradeUtil;
import org.junit.Before;
import org.junit.Ignore;

/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Joram Barrez
 */
@Ignore
public abstract class UpgradeTestCase {
	
  protected ProcessEngine processEngine;
  protected ProcessEngineConfigurationImpl processEngineConfiguration;
  protected TaskService taskService;
  protected RuntimeService runtimeService;
  protected RepositoryService repositoryService;
  protected ManagementService managementService;
  protected FormService formService;
  protected IdentityService identityService;
  protected HistoryService historyService;
  
  protected boolean runningTests;
  
  @Before
  public void setup() {
  	this.processEngine = UpgradeUtil.getProcessEngine("activiti.cfg.xml");
    this.processEngineConfiguration = (ProcessEngineConfigurationImpl) processEngine.getProcessEngineConfiguration();
    this.taskService = processEngine.getTaskService();
    this.runtimeService = processEngine.getRuntimeService();
    this.repositoryService = processEngine.getRepositoryService();
    this.managementService = processEngine.getManagementService();
    this.formService = processEngine.getFormService();
    this.identityService = processEngine.getIdentityService();
    this.historyService = processEngine.getHistoryService();
    
    this.runningTests = TestAnnotationUtil.validateRunOnlyWithTestDataFromVersionAnnotation(this.getClass());
  }

}
