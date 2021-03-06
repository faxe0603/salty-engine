/*
 * Copyright 2018 Malte Dostal
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.edgelord.saltyengine.components;

import de.edgelord.saltyengine.core.Component;
import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.core.stereotypes.ComponentContainer;
import de.edgelord.saltyengine.gameobject.Components;

public class FixedRate extends Component {

    private int gate;
    private int ticks = 0;

    private boolean now = false;

    public FixedRate(ComponentContainer parent, String name, int gate) {
        super(parent, name, Components.TIMING_COMPONENT);
        this.gate = gate;
    }

    public boolean now() {
        return now;
    }

    @Override
    public void onFixedTick() {

        if (ticks == gate) {
            now = true;
            ticks = 0;
        } else {
            now = false;
            ticks++;
        }
    }

    @Override
    public void draw(SaltyGraphics saltyGraphics) {

    }

    @Override
    public void onCollision(CollisionEvent e) {

    }

    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }
}
