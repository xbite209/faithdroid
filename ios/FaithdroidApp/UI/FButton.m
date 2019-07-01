//
//  FButton.m
//  FaithdroidApp
//
//  Created by steven zacker on 6/29/19.
//  Copyright © 2019 steven zacker. All rights reserved.
//

#import "ui.h"
@implementation FButton

@synthesize v;

- ( id _Nonnull )initWithParm:(long)myid bridge:(UIObjectCBridge *_Nonnull)bridge{
    self = [super init];
    if (self) {
        v = [UIButton buttonWithType:UIButtonTypeSystem];
        [v setTitle:@"click me" forState:UIControlStateNormal];
        v.frame = CGRectMake(80.0, 210.0, 160.0, 40.0);
        vid = myid;
        parentUIBridge = bridge;
        view = v;
    }
    return self;
}


-(bool)setAttr:(long)attr value:(NSString *_Nullable)value{
    if ([super setAttr:attr value:value]){
        return true;
    }
    switch (attr) {
    }
    return true;
}

-(NSString*_Nullable)getAttr:(long)attr{
    NSString* str = [super getAttr:attr];
    if (str!=nil) {
        return str;
    }
    return @"";
}
@end