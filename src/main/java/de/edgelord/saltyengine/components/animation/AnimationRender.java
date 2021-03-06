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

package de.edgelord.saltyengine.components.animation;

import de.edgelord.saltyengine.components.rendering.RenderComponent;
import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.core.stereotypes.ComponentContainer;
import de.edgelord.saltyengine.effect.Animation;
import de.edgelord.saltyengine.gameobject.Components;

/**
 * A {@link de.edgelord.saltyengine.core.Component} that renders an {@link Animation}.
 * After each {@link #ticksPerFrame} amount of fixed ticks, the next frame of the animation will be drawn.
 */
public class AnimationRender extends RenderComponent {

    /**
     * The Animation which should be drawn
     */
    private Animation animation = null;

    /**
     * The number of fixed ticks after which the next frame should be drawn
     */
    private int ticksPerFrame = 75;

    /**
     * The current number of fixed ticks; when it reaches #ticksPerFrame it will be reset to 0 again
     */
    private int ticks = 0;

    /**
     * The default super constructor for gameObjectComponent, which takes in the parent GameObject and the
     * name, used as an id, for fishing specific components out of a list
     *
     * @param parent the parent of the Component, so where to take the e.g. the Coordinate info from
     * @param name   the id-name for this Component
     * @see de.edgelord.saltyengine.core.Component
     */
    public AnimationRender(ComponentContainer parent, String name) {
        super(parent, name, Components.RENDER_COMPONENT);
    }

    /**
     * A constructor with all necessary parameters
     *
     * @param parent        the parent of the Component
     * @param name          the id-name of this Component
     * @param animation     the animation that should be rendered
     * @param ticksPerFrame after how many fixed ticks the next frame of the animation should be triggered
     */
    public AnimationRender(ComponentContainer parent, String name, Animation animation, int ticksPerFrame) {
        super(parent, name, Components.RENDER_COMPONENT);
        this.animation = animation;
        this.ticksPerFrame = ticksPerFrame;
    }

    /**
     * Draws the current frame of the animation
     *
     * @param saltyGraphics the SaltyGraphics to which the component should draw
     * @see #onFixedTick()
     * @see #animation
     * @see de.edgelord.saltyengine.core.Component
     */
    @Override
    public void draw(SaltyGraphics saltyGraphics) {

        if (animation != null) {
            animation.drawCurrentFrame(saltyGraphics);
        }
    }

    /**
     * On every fixed tick, {@link #ticks} is incremented; when it reaches {@link #ticksPerFrame},
     * the next frame of {@link #animation} is triggered and ticks will be reset to 0
     */
    @Override
    public void onFixedTick() {
        if (ticks == ticksPerFrame) {
            if (animation != null) {
                animation.nextFrame();
                ticks = 0;
            }
        } else if (animation != null) {
            ticks++;
        }
    }

    /**
     * @return the animation that this component renders.
     */
    public Animation getAnimation() {
        return animation;
    }

    /**
     * Sets the animation to be rendered.
     *
     * @param animation the new animation
     */
    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    /**
     * @return the fixed ticks per frame of the animation.
     */
    public int getTicksPerFrame() {
        return ticksPerFrame;
    }

    /**
     * Sets how many fixed ticks should last until the next frame of the animation.
     *
     * @param ticksPerFrame the new value
     */
    public void setTicksPerFrame(int ticksPerFrame) {
        this.ticksPerFrame = ticksPerFrame;
        ticks = 0;
    }
}
