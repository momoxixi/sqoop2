/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sqoop.handler;

import org.apache.log4j.Logger;
import org.apache.sqoop.common.VersionInfo;
import org.apache.sqoop.json.JsonBean;
import org.apache.sqoop.json.VersionBean;
import org.apache.sqoop.server.RequestContext;
import org.apache.sqoop.server.RequestHandler;

/**
 * Version request handler is supporting following resources:
 *
 * GET /version
 * Get server version and supported protocol versions.
 */
public class VersionRequestHandler implements RequestHandler {

  private static final Logger LOG =
      Logger.getLogger(VersionRequestHandler.class);

  /** The API version supported by this server */
  public static final String PROTOCOL_V1 = "1";


  private final VersionBean versionBean;

  public VersionRequestHandler() {
    String[] protocols = { PROTOCOL_V1 };
    versionBean = new VersionBean(VersionInfo.getVersion(),
        VersionInfo.getRevision(), VersionInfo.getDate(),
        VersionInfo.getUser(), VersionInfo.getUrl(), protocols);

    LOG.info("VersionRequestHandler initialized");
  }


  @Override
  public JsonBean handleEvent(RequestContext ctx) {
    return versionBean;
  }
}
