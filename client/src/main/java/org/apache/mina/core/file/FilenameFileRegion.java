/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.apache.mina.core.file;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * TODO Add documentation
 *
 * @author The Apache MINA Project (dev@mina.apache.org)
 * @version $Rev$, $Date$
 */
public class FilenameFileRegion extends DefaultFileRegion {

    private final File file;

    public FilenameFileRegion(File file, FileChannel channel) throws IOException {
        this(file, channel, 0, file.length());
    }

    public FilenameFileRegion(File file, FileChannel channel, long position, long remainingBytes) {
        super(channel, position, remainingBytes);

        if (file == null) {
            throw new IllegalArgumentException("file can not be null");
        }
        this.file = file;
    }

    public String getFilename() {
        return file.getAbsolutePath();
    }
}
