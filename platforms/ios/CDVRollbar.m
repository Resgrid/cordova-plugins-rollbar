//
//  Rollbar Cordova iOS Plugin
//	by Resgrid (http://resgrid.com)
//  
//

#import "CDVRollbar.h"

@implementation CDVRollbar

- (void)pluginInitialize
{
	NSString *RollbarAccessToken = [[NSBundle mainBundle] objectForInfoDictionaryKey:@"RollbarAccessToken"];
	NSString *RollbarEnvironment = [[NSBundle mainBundle] objectForInfoDictionaryKey:@"RollbarEnvironment"];
	
	RollbarConfiguration *config = [RollbarConfiguration configuration];
	config.crashLevel = @"critical";
	config.environment = RollbarEnvironment;

	[Rollbar initWithAccessToken:RollbarAccessToken configuration:config];
}

- (void)init:(CDVInvokedUrlCommand *)command
{

}

@end

