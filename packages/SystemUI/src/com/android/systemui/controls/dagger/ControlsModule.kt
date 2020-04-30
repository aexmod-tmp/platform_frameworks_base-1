/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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

package com.android.systemui.controls.dagger

import android.app.Activity
import com.android.systemui.controls.controller.ControlsBindingController
import com.android.systemui.controls.controller.ControlsBindingControllerImpl
import com.android.systemui.controls.controller.ControlsController
import com.android.systemui.controls.controller.ControlsControllerImpl
import com.android.systemui.controls.controller.ControlsFavoritePersistenceWrapper
import com.android.systemui.controls.management.ControlsEditingActivity
import com.android.systemui.controls.management.ControlsFavoritingActivity
import com.android.systemui.controls.management.ControlsListingController
import com.android.systemui.controls.management.ControlsListingControllerImpl
import com.android.systemui.controls.management.ControlsProviderSelectorActivity
import com.android.systemui.controls.management.ControlsRequestDialog
import com.android.systemui.controls.ui.ControlsUiController
import com.android.systemui.controls.ui.ControlsUiControllerImpl
import com.android.systemui.controls.ui.ControlActionCoordinator
import com.android.systemui.controls.ui.ControlActionCoordinatorImpl
import dagger.Binds
import dagger.BindsOptionalOf
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ControlsModule {

    @Binds
    abstract fun provideControlsListingController(
        controller: ControlsListingControllerImpl
    ): ControlsListingController

    @Binds
    abstract fun provideControlsController(controller: ControlsControllerImpl): ControlsController

    @Binds
    abstract fun provideControlsBindingController(
        controller: ControlsBindingControllerImpl
    ): ControlsBindingController

    @Binds
    abstract fun provideUiController(controller: ControlsUiControllerImpl): ControlsUiController

    @Binds
    abstract fun provideControlActionCoordinator(
        coordinator: ControlActionCoordinatorImpl
    ): ControlActionCoordinator

    @BindsOptionalOf
    abstract fun optionalPersistenceWrapper(): ControlsFavoritePersistenceWrapper

    @Binds
    @IntoMap
    @ClassKey(ControlsProviderSelectorActivity::class)
    abstract fun provideControlsProviderActivity(
        activity: ControlsProviderSelectorActivity
    ): Activity

    @Binds
    @IntoMap
    @ClassKey(ControlsFavoritingActivity::class)
    abstract fun provideControlsFavoritingActivity(
        activity: ControlsFavoritingActivity
    ): Activity

    @Binds
    @IntoMap
    @ClassKey(ControlsEditingActivity::class)
    abstract fun provideControlsEditingActivity(
        activity: ControlsEditingActivity
    ): Activity

    @Binds
    @IntoMap
    @ClassKey(ControlsRequestDialog::class)
    abstract fun provideControlsRequestDialog(
        activity: ControlsRequestDialog
    ): Activity
}
