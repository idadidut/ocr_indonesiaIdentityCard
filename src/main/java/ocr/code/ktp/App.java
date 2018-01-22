package ocr.code.ktp;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * Hello world!
 *
 */
public class App extends AbstractVerticle
{
    @Override
    public void start(Future <Void> f) {
    	vertx
    		.createHttpServer()
    		.requestHandler(r -> {
    			r.response().end("<h1> HALO </h1>");
    		})
    		.listen(8080, result -> {
    			if(result.succeeded()) {
    				f.complete();
    			} else {
    				f.fail(result.cause());
    			}
    		});
    }
}
