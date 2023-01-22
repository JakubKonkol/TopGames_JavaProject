//
//  UserService.swift
//  topgames-ios-app
//
//  Created by Jakub Konkol on 22/01/2023.
//

import Foundation
import Alamofire

class UserService {
    var users: [User] = []
    func getAllUsers() {
            let url = "http://localhost:8081/api/user/getAll"
            
            AF.request(url)
                .validate()
                .responseDecodable(of: [User].self) { (response) in
                    switch response.result {
                    case .success(let users):
                        self.users = users
                    case .failure(let error):
                        print(error)
                    }
            }
        }
}

