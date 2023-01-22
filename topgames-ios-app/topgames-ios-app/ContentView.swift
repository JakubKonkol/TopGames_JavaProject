//
//  ContentView.swift
//  topgames-ios-app
//
//  Created by Jakub Konkol on 22/01/2023.
//

import SwiftUI

struct ContentView: View {
    @State private var users: [User] = []

    var body: some View {
        VStack {
            Text("UserService")
            List {
                ForEach(users) { user in
                    Text(user.username)
                }
            }
        }
        .padding()
        .onAppear(perform: loadData)
    }
    
    private func loadData() {
        let userService = UserService()
        userService.getAllUsers()
        self.users = userService.users
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

