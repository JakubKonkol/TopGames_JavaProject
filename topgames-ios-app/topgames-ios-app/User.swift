//
//  User.swift
//  topgames-ios-app
//
//  Created by Jakub Konkol on 22/01/2023.
//

import Foundation
struct User: Codable, Identifiable{
    
    let id: Int
    let username: String
    let email: String
    let firstname: String
    let lastname: String
    
}
