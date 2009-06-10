/*
 * Copyright (C) 2009 Jayway AB
 * Copyright (C) 2007-2008 JVending Masa
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
package com.jayway.maven.plugins.android.standalonemojos;

import com.jayway.maven.plugins.android.AbstractAndroidMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import java.io.File;

/**
 * Deploys a separate apk file to a connected device.<br/>
 * @goal deploy-file
 * @requiresProject false
 * @author hugo.josefson@jayway.com
 */
public class DeployFileMojo extends AbstractAndroidMojo {

    /**
     * The apk file to deploy to a connected emulator or usb device.
     * @parameter expression="${file}"
     * @required
     */
    private File file;

    public void execute() throws MojoExecutionException, MojoFailureException {

        if (undeployApkBeforeDeploying){
            undeployApk(file);
        }
        deployApk(file);
    }

}