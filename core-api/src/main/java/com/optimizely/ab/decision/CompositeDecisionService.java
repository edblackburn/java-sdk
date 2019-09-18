/****************************************************************************
 * Copyright 2019, Optimizely, Inc. and contributors                        *
 *                                                                          *
 * Licensed under the Apache License, Version 2.0 (the "License");          *
 * you may not use this file except in compliance with the License.         *
 * You may obtain a copy of the License at                                  *
 *                                                                          *
 *    http://www.apache.org/licenses/LICENSE-2.0                            *
 *                                                                          *
 * Unless required by applicable law or agreed to in writing, software      *
 * distributed under the License is distributed on an "AS IS" BASIS,        *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. *
 * See the License for the specific language governing permissions and      *
 * limitations under the License.                                           *
 ***************************************************************************/
package com.optimizely.ab.decision;

import com.optimizely.ab.config.Experiment;
import com.optimizely.ab.config.ProjectConfig;
import com.optimizely.ab.decision.entities.ExperimentDecision;
import com.optimizely.ab.decision.experiment.CompositeExperimentService;
import com.optimizely.ab.event.internal.UserContext;

import javax.annotation.Nonnull;

/**
 * Optimizely's decision service that determines which variation of an experiment the user will be allocated to.
 */
public class CompositeDecisionService implements IDecisionService {
    /**
     * Returns a ExperimentDecision for the given user and experiment
     *
     * @param experiment  The Experiment the user will be bucketed into.
     * @param userContext It have user id, attributes and a reference to the current {@link ProjectConfig}
     * @return {@link ExperimentDecision}
     */
    @Override
    public ExperimentDecision getExperimentDecision(@Nonnull Experiment experiment,
                                                    @Nonnull UserContext userContext) {
        return new CompositeExperimentService().getDecision(experiment, userContext);
    }
}
