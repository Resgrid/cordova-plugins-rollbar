//
//  Rollbar Cordova iOS Plugin
//	by Resgrid (http://resgrid.com)
//  
//

#import <Rollbar/Rollbar.h>

@implementation CDVRollbar

- (void)init:(CDVInvokedUrlCommand *)command
{
    NSString *accessToken = [command.arguments objectAtIndex:0];
    NSString *environment = [command.arguments objectAtIndex:1];
	
	RollbarConfiguration *config = [RollbarConfiguration configuration];
	config.crashLevel = @"critical";
	config.environment = environment;

	[Rollbar initWithAccessToken:accessToken configuration:config];
}

@end

