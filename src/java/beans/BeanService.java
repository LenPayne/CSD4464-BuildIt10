/*
 * Copyright 2016 Len Payne <len.payne@lambtoncollege.ca>.
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
package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * This is a Session Scoped Web Service that listens for requests to manage user info
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
@Path("/beans")
/* By default, JAX-RS is not Session Scoped, so we must specifically define that
 * our web service is Session Scoped or the rest of the parts of the conversation 
 * (eg- LoginBean) won't know what context they're running within.
 */
@SessionScoped
public class BeanService implements Serializable {

    // Each user gains a LoginBean based on their specific visit
    @Inject
    LoginBean login;

    // Each user gains access to a LogBean during each request
    @Inject
    LogBean log;

    @GET
    @Produces("application/json")
    public JsonObject get() {
        // Builds a JSON Object based on the contents of the LoginBean
        JsonObject json = Json.createObjectBuilder().
                add("name", login.getName()).build();
        return json;
    }

    @POST
    @Consumes("application/json")
    public void post(JsonObject json) {
        // Changes the values in the SessionScoped LoginBean
        login.setName(json.getString("name"));
        // Uses the utlity bean LogBean to print formatted text to the server log
        log.log("Set name to: " + json.getString("name"));
    }
}
